package ua.smartHome.switchers;

import lombok.Getter;
import lombok.Setter;

public abstract class Relay {

    @Setter
    @Getter
    public String relayStatus = "OFF";

    @Setter
    @Getter
    public boolean Status;

//    public String updateRelayStatus = "OFF";

    @Setter
    @Getter
    public String sensorId;

    @Setter
    @Getter
    public String sensorDataValue;


}
