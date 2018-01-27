package frc.team166.chopshoplib.sensors;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.SensorBase;
import edu.wpi.first.wpilibj.smartdashboard.SendableBuilder;

public class Lidar extends SensorBase {
    I2C I2CBuss;

    public enum Unit {
        /**
         * Use inches for PIDGet.
         */
        kInches,
        /**
         * Use millimeters for PIDGet.
         */
        kMillimeters
    }

    @Override
    public void initSendable(SendableBuilder builder) {
        builder.setSmartDashboardType("LiDAR");
        double dDistance = (double) GetDistance();
        builder.addDoubleProperty("Distance", () -> {
            return (dDistance);
        }, null);

    }

    public Lidar(int kAddress) {
        I2CBuss = new I2C(I2C.Port.kOnboard, kAddress);
    }

    public int GetDistance() {

        byte[] dataBuffer = new byte[2];
        I2CBuss.write(0x44, 0x1);
        I2CBuss.readOnly(dataBuffer, 2);
        int iDistance = dataBuffer[0] << 8 | dataBuffer[1];
        return iDistance;
    }
}