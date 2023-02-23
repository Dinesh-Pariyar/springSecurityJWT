package com.backuppractise.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.*;
import java.util.Arrays;
import java.util.Timer;

@Configuration
@EnableScheduling
public class BackupInJAVA {

//    @Autowired
//            @Lazy
//    Restore restore;
    static final Logger logger = LoggerFactory.getLogger(BackupInJAVA.class);

    public boolean isBacking=false;
    @Scheduled(fixedRate = 28999)
    public void backup() throws IOException, InterruptedException {

        isBacking=true;
        Restore restore = new Restore();
        boolean restoreProcess=restore.isRestore;
        System.out.println("restoreing "+restoreProcess);

        if (restoreProcess){
            logger.warn("restore is now in process backup will be scheduled after 10 second");
            System.out.println("inside backup where restore is now in process will process after 10 sec");
            Timer T = new Timer();
//            T.schedule(backup(),10000);
        }else{
            File backupFile = new File("/home/dinesh/dump/backup.sql");
            String[] command = new String[]{"mysqldump", "--login-path=sqlLogin", "User"};

            ProcessBuilder processBuilder = new ProcessBuilder(Arrays.asList(command));
            processBuilder.redirectError(ProcessBuilder.Redirect.INHERIT);
            processBuilder.redirectOutput(ProcessBuilder.Redirect.to(backupFile));

            Process process = processBuilder.start();

            if (process.waitFor() == 0) {
                System.out.println("Backup is done");
                Thread.sleep(2000);

            }else{
                logger.error("error occur while backup");
            }
        }
        isBacking=false;
    }

}
