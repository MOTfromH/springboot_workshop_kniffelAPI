package com.mot.kniffel;
import org.apache.catalina.Server;
import org.springframework.web.bind.annotation.*;
import java.lang.management.*;

@RestController
// this is the base URL for all endpoint methods in this class
@CrossOrigin
@RequestMapping("/api/v1/server")
public class ServerStatusController {



    @PostMapping("/thread-dump")
    public void threadDump(){
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        for (ThreadInfo threadinfo : threadMXBean.dumpAllThreads(true,true)){
            System.out.println(threadinfo);
        }
    }
    @GetMapping("/status")
    public ServerStatus getServerStatus(){
        ServerStatus serverStatus = new ServerStatus();


        serverStatus.setServerTime(System.currentTimeMillis());
        serverStatus.setServerVersion("1.0.0");
        serverStatus.setServerName("Kniffel Server");
        serverStatus.setServerStatus("OK");
        return serverStatus;
    }

}
