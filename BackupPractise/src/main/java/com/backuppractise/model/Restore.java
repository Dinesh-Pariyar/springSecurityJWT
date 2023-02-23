package com.backuppractise.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

@RestController
public class Restore {
//    @Autowired
//            @Lazy
//    BackupInJAVA backup;
    public boolean isRestore = false;
    private static final Logger logger = LoggerFactory.getLogger(Restore.class);

    //    @GetMapping("/restore")
//    @Scheduled(cron = "*/29 * * * * *")
//    @Scheduled(fixedRate = 28999)
    public TimerTask restore() throws InterruptedException, IOException {
        isRestore=true;
        BackupInJAVA backup = new BackupInJAVA();
        boolean backing = backup.isBacking;
        System.out.println("backing === :: "+backing);
        if (backing == true) {
            System.out.println("inside restore where back up is true");
            System.out.println("backing inside true"+backing);
            Timer T = new Timer();
            T.schedule(restore(),10000);
            logger.error("Back up is in process try after 30 second second");
        } else {
            File backupFile = new File("/home/dinesh/dump/backup.sql");
            String[] command = new String[]{"mysql", "--login-path=sqlLogin", "restore"};
            ProcessBuilder processBuilder = new ProcessBuilder(Arrays.asList(command));

            processBuilder.redirectError(ProcessBuilder.Redirect.INHERIT);
            processBuilder.redirectInput(ProcessBuilder.Redirect.from(backupFile));

            Process process = processBuilder.start();
            process.waitFor();
            System.out.println("restoring is done");
            isRestore = false;
        }
        return null;
    }
}
