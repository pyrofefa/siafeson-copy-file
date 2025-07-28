import { CopyFileSiafeson } from 'siafeson-copy-file';

window.testEcho = () => {
    const inputValue = document.getElementById("echoInput").value;
    CopyFileSiafeson.echo({ value: inputValue })
}
