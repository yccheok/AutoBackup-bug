# AutoBackup-bug
https://stackoverflow.com/questions/57211036/why-backup-related-process-might-cause-applications-oncreate-is-not-executed


<Run the app from Android studio>

2019-07-26 20:02:46.202 24831-24831/? I/CHEOK: CheokApplication onCreate
2019-07-26 20:02:46.658 24831-24831/? I/CHEOK: In MainActivity, CheokApplication = com.yocto.cheok.CheokApplication@fb79716
2019-07-26 20:02:46.658 24831-24831/? I/CHEOK: CheokApplication doSomething


c:\yocto>adb shell bmgr backupnow com.yocto.cheok
Running incremental backup for 1 requested packages.
Package @pm@ with result: Success
Package com.yocto.cheok with progress: 1536/1024
Package com.yocto.cheok with progress: 2048/1024
Package com.yocto.cheok with progress: 2560/1024
Package com.yocto.cheok with result: Success
Backup finished with result: Success

<App close, Tap to launch the app again>

2019-07-26 20:03:30.037 25609-25609/com.yocto.cheok I/CHEOK: CheokApplication onCreate
2019-07-26 20:03:30.379 25609-25609/com.yocto.cheok I/CHEOK: In MainActivity, CheokApplication = com.yocto.cheok.CheokApplication@fb79716
2019-07-26 20:03:30.379 25609-25609/com.yocto.cheok I/CHEOK: CheokApplication doSomething

c:\yocto>adb shell bmgr restore com.yocto.cheok
restoreStarting: 1 packages
onUpdate: 0 = com.yocto.cheok
restoreFinished: 0
done

<App close, Tap to launch the app again>

2019-07-26 20:04:08.901 25945-25945/com.yocto.cheok I/CHEOK: In MainActivity, CheokApplication = null

<Crash due to NPE>
