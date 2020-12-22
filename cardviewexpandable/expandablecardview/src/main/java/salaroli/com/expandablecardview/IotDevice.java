package salaroli.com.expandablecardview;

public class IotDevice {
    private int idDevice = 0;
    private int resourceIconDevice;
    private String textDevice;

    public IotDevice(int idDevice, int resourceIconDevice, String textDevice) {
        this.idDevice = idDevice;
        this.resourceIconDevice = resourceIconDevice;
        this.textDevice = textDevice;
    }

    public IotDevice(int resourceIconDevice, String textDevice) {
        this.resourceIconDevice = resourceIconDevice;
        this.textDevice = textDevice;
    }

    public int getResourceIconDevice() {
        return resourceIconDevice;
    }

    public void setResourceIconDevice(int resourceIconDevice) {
        this.resourceIconDevice = resourceIconDevice;
    }

    public String getTextDevice() {
        return textDevice;
    }

    public void setTextDevice(String textDevice) {
        this.textDevice = textDevice;
    }

    public int getIdDevice() {
        return idDevice;
    }

    public void setIdDevice(int idDevice) {
        this.idDevice = idDevice;
    }
}
