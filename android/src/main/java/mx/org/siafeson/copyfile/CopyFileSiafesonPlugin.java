package mx.org.siafeson.copyfile;

import android.content.Context;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.getcapacitor.PluginMethod;

import java.io.*;

@CapacitorPlugin(name = "CopyFileSiafeson")
public class CopyFileSiafesonPlugin extends Plugin {

    @PluginMethod
    public void copyDatabaseToExternal(PluginCall call) {
        String dbName = call.getString("dbName");

        if (dbName == null || dbName.isEmpty()) {
            call.reject("dbName es requerido");
            return;
        }

        Context context = getContext();
        File source = context.getDatabasePath(dbName);
        File target = new File(context.getExternalFilesDir(null), dbName);

        try {
            copy(source, target);
            call.resolve();
        } catch (IOException e) {
            call.reject("Error copiando base de datos", e);
        }
    }

    @PluginMethod
    public void importDatabaseFromExternal(PluginCall call) {
      Context context = getContext();
      File dbDir = context.getDatabasePath("placeholder").getParentFile();

      File oldDb = new File(dbDir, "trampeo.db");
      File newDb = new File(dbDir, "trampeoSQLite.db");

      if (oldDb.exists() && !newDb.exists()) {
          boolean copied = oldDb.renameTo(newDb);
          JSObject ret = new JSObject();
          ret.put("migrated", copied);
          call.resolve(ret);
      } else {
          JSObject ret = new JSObject();
          ret.put("migrated", false);
          call.resolve(ret);
      }
    }

    private void copy(File src, File dst) throws IOException {
        try (InputStream in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(dst)) {

            byte[] buf = new byte[1024];
            int len;

            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
        }
    }
}
