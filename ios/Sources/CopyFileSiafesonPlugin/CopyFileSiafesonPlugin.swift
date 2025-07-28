import Foundation
import Capacitor

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(CopyFileSiafesonPlugin)
public class CopyFileSiafesonPlugin: CAPPlugin, CAPBridgedPlugin {
    public let identifier = "CopyFileSiafesonPlugin"
    public let jsName = "CopyFileSiafeson"
    public let pluginMethods: [CAPPluginMethod] = [
        CAPPluginMethod(name: "echo", returnType: CAPPluginReturnPromise)
    ]
    private let implementation = CopyFileSiafeson()

    @objc func echo(_ call: CAPPluginCall) {
        let value = call.getString("value") ?? ""
        call.resolve([
            "value": implementation.echo(value)
        ])
    }
}
