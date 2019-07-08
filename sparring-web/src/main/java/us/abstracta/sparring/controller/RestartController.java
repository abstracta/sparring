package us.abstracta.sparring.controller;

import org.springframework.util.DefaultPropertiesPersister;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import us.abstracta.sparring.SparringServicesApplication;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Properties;

@RestController
public class RestartController {

    @PostMapping("/restart")
    public void restart() {
        SparringServicesApplication.restart();
    }

    @PutMapping("/setIssue/{issue}/{value}")
    public void setIssue(@PathVariable("issue") String issue, @PathVariable("value") String value) {
        try {
            File f = new File("application.properties");
            Properties props = new Properties();
            if (f.exists()){
                FileInputStream in = new FileInputStream( f );
                props.load(in);
            }
            props.setProperty(issue, value);
            DefaultPropertiesPersister p = new DefaultPropertiesPersister();
            OutputStream out = new FileOutputStream( f );
            p.store(props, out, "Properties that overrides the values of the application.properties inside the jar");

        } catch (Exception e ) {
            e.printStackTrace();
        }
        SparringServicesApplication.restart();
    }
}
