package com.dvalpha.core.utils;

public class TransformBytesToTB {
	double KB,MB,GB,TB;

    public TransformBytesToTB(long bytes){  
    obtenerTB(bytes);
    }
    public double obtenerKb(long bytes){
    setKB(bytes/1024);
    return getKB();
    
    }
    
    public double obtenerMB(long bytes){
    setMB(obtenerKb(bytes)/1024);
    return getMB();
    
    }
    
    public double obtenerGB(long bytes){
    setGB(obtenerMB(bytes)/1024);
    return getGB();
    }
    public double obtenerTB(long bytes){
    setTB(obtenerGB(bytes)/1024);
    return getTB();
    }

    @Override
    public String toString() {
        return "FileTransformBytes{" + "KB=" + KB + ", MB=" + MB + ", GB=" + GB + ", TB=" + TB + '}';
    }
    
    
    
    
    public double getKB() {
        return KB;
    }

    public void setKB(double KB) {
        this.KB = KB;
    }

    public double getMB() {
        return MB;
    }

    public void setMB(double MB) {
        this.MB = MB;
    }

    public double getGB() {
        return GB;
    }

    public void setGB(double GB) {
        this.GB = GB;
    }

    public double getTB() {
        return TB;
    }

    public void setTB(double TB) {
        this.TB = TB;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
