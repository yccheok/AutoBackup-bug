# AutoBackup-bug
https://stackoverflow.com/questions/57211036/why-backup-related-process-might-cause-applications-oncreate-is-not-executed

Testing was done in Xiaomi A1 device, with Android 9.

    <Run the app from Android studio>

    2019-07-26 20:33:37.514 5269-5269/com.yocto.cheok I/CHEOK: CheokApplication onCreate
    2019-07-26 20:33:38.070 5269-5269/com.yocto.cheok I/CHEOK: In MainActivity, CheokApplication = com.yocto.cheok.CheokApplication@fb79716
    2019-07-26 20:33:38.071 5269-5269/com.yocto.cheok I/CHEOK: In MainActivity, this.getApplication() = com.yocto.cheok.CheokApplication@fb79716
    2019-07-26 20:33:38.071 5269-5269/com.yocto.cheok I/CHEOK: CheokApplication doSomething


    c:\yocto>adb shell bmgr backupnow com.yocto.cheok
    Running incremental backup for 1 requested packages.
    Package @pm@ with result: Success
    Package com.yocto.cheok with progress: 1536/1024
    Package com.yocto.cheok with progress: 2048/1024
    Package com.yocto.cheok with progress: 2560/1024
    Package com.yocto.cheok with result: Success
    Backup finished with result: Success

    <App close, Tap to launch the app again>

    2019-07-26 20:35:29.494 6212-6212/? I/CHEOK: CheokApplication onCreate
    2019-07-26 20:35:29.820 6212-6212/? I/CHEOK: In MainActivity, CheokApplication = com.yocto.cheok.CheokApplication@fb79716
    2019-07-26 20:35:29.820 6212-6212/? I/CHEOK: In MainActivity, this.getApplication() = com.yocto.cheok.CheokApplication@fb79716
    2019-07-26 20:35:29.820 6212-6212/? I/CHEOK: CheokApplication doSomething

    c:\yocto>adb shell bmgr restore com.yocto.cheok
    restoreStarting: 1 packages
    onUpdate: 0 = com.yocto.cheok
    restoreFinished: 0
    done

    <App close, Tap to launch the app again>

    2019-07-26 20:35:54.397 6270-6270/com.yocto.cheok I/CHEOK: In MainActivity, CheokApplication = null
    2019-07-26 20:35:54.397 6270-6270/com.yocto.cheok I/CHEOK: In MainActivity, this.getApplication() = android.app.Application@c84226d

    <Crash due to NPE>

An interesting observation is that, when problem happens, App custom defined Application class will not be created. Instead, original android.app.Application will be created. This can be observed via activity.getApplication().

