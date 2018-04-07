package com.dvalpha.core.utils;
import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;
public class SystemInfo {

	private Runtime runtime = Runtime.getRuntime();
    private String almacenamiento;
    private String totalRam;
    private String freeRam;
    private String freeHD;
    private String totalHD;
    public String Info() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.OsInfo());
        sb.append(this.MemInfo());
        sb.append(this.DiskInfo());
        return sb.toString();
    }
 public String InfoShort() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.OsInfo());
        sb.append(this.MemInfo());
        sb.append(this.DiskInfo());
        return sb.toString();
    }

    public String OSname() {
        return System.getProperty("os.name");
    }

    public String OSversion() {
        return System.getProperty("os.version");
    }

    public String OsArch() {
        return System.getProperty("os.arch");
    }

    public long totalMem() {
        return Runtime.getRuntime().totalMemory();
    }

    private int mb = 1073741824;
    public long maxMemory() {

        return runtime.maxMemory()  /mb;
    }
    public long freeMemory() {

        return runtime.freeMemory()  /mb;
    }
   
    
    public long usedMem() {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    public String MemInfo() {
        NumberFormat format = NumberFormat.getInstance();
        StringBuilder sb = new StringBuilder();
        long maxMemory = runtime.maxMemory();
        long allocatedMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        sb.append("Free memory ( JVM ): ");
        sb.append(format.format(freeMemory / 1024));
        sb.append("<br/>");
        sb.append("Allocated( JVM ): ");
        sb.append(format.format(allocatedMemory / 1024));
        sb.append("<br/>");
        sb.append("Max ( JVM ): ");
        sb.append(format.format(maxMemory / 1024));
        sb.append("<br/>");
        sb.append("Total free( JVM ): ");
        long mem =(freeMemory + (maxMemory - allocatedMemory))/1024;
        
        if(mem<800){
        sb.append("<span class=\"label label-danger\" style=\"font-size:11px;font-weight: normal\">"+format.format((freeMemory + (maxMemory - allocatedMemory)) / 1024)+" Danger!</span>");
        sb.append("<br/>");
        }else{
         sb.append(format.format((freeMemory + (maxMemory - allocatedMemory)) / 1024));
         sb.append("<br/>");
        }
        double d = (freeMemory + (maxMemory - allocatedMemory));
        Double total = d/mb;
        DecimalFormat df = new DecimalFormat("#.00"); 
        
        setFreeRam(df.format(total)+"GB");
        return sb.toString();

    }

    public String OsInfo() {
        StringBuilder sb = new StringBuilder();
        //sb.append("OS: ");
       // sb.append(this.OSname());
        
        sb.append("Version: ");
        sb.append(this.OSversion());
        sb.append(" | ");
        sb.append("CORE: ");
        sb.append(this.OsArch());
        sb.append("<br/>");
        sb.append("Available processors (cores): ");
        sb.append(runtime.availableProcessors());
        sb.append("<br/>");
        return sb.toString();
    }

    public String DiskInfo() {
        /* Get a list of all filesystem roots on this system */
        File[] roots = File.listRoots();
        StringBuilder sb = new StringBuilder();

        /* For each filesystem root, print some info */
        for (File root : roots) {
            sb.append("File system root: ");
            sb.append(root.getAbsolutePath());
            sb.append("<br/>");
            sb.append("Total(GB): ");
            Double t =Double.valueOf(root.getTotalSpace());
            Double total = t/mb;
            DecimalFormat df = new DecimalFormat("#.00"); 
            sb.append(df.format(total));
            setTotalHD(df.format(total));
            sb.append(" | ");
            sb.append("Free(GB): ");
            Double f =Double.valueOf(root.getFreeSpace());
            Double free = f/mb;
            sb.append(df.format(free));
            setFreeHD(df.format(free));
            
            break;
        }
        return sb.toString();
    }

    public String getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(String almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public String getTotalRam() {
        return totalRam;
    }

    public void setTotalRam(String totalRam) {
        this.totalRam = totalRam;
    }

    public String getFreeRam() {
        return freeRam;
    }

    public void setFreeRam(String freeRam) {
        this.freeRam = freeRam;
    }

    public int getMb() {
        return mb;
    }

    public void setMb(int mb) {
        this.mb = mb;
    }

    public Runtime getRuntime() {
        return runtime;
    }

    public void setRuntime(Runtime runtime) {
        this.runtime = runtime;
    }

    public String getFreeHD() {
        return freeHD;
    }

    public void setFreeHD(String freeHD) {
        this.freeHD = freeHD;
    }

    public String getTotalHD() {
        return totalHD;
    }

    public void setTotalHD(String totalHD) {
        this.totalHD = totalHD;
    }
    
}
