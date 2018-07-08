package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Configurations")
public class Configuration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @ManyToMany(mappedBy = "configurations")
    private List<Device> devices= new ArrayList<>();

    /*
    @ManyToMany(mappedBy = "users")
    private Set<User> users = new HashSet<>();
    */

    @ManyToOne
    public Application application;

    @OneToOne(fetch=FetchType.EAGER, mappedBy="configuration",cascade = CascadeType.ALL, orphanRemoval = true)
    private QRCode qrCode;

    private int amtDevicesPermitted;

    public int getId() {
        return id;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public int getAmtDevicesPermitted() {
        return amtDevicesPermitted;
    }

    public void setAmtDevicesPermitted(int amtDevicesPermitted) {
        this.amtDevicesPermitted = amtDevicesPermitted;
    }

    public QRCode getQrCode() {
        return qrCode;
    }

    public void setQrCode(QRCode qrCode) {
        this.qrCode = qrCode;
    }
}
