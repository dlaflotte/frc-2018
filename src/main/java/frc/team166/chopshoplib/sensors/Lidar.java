package frc.team166.chopshoplib.sensors;

import java.nio.ByteBuffer;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.SensorBase;
import edu.wpi.first.wpilibj.smartdashboard.SendableBuilder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Lidar extends SensorBase {
    I2C I2CBus;

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

        NetworkTableEntry mmDistance = builder.getEntry("Distance");

        builder.setUpdateTable(() -> {
            mmDistance.setNumber(GetDistance());
        });
    }

    public Lidar(int kAddress) {
        I2CBus = new I2C(I2C.Port.kOnboard, kAddress);
    }

    public int GetDistance() {
        byte[] dataBuffer = new byte[2];
<<<<<<< refs/remotes/JoshLaflotte/Drive
        I2CBus.write(0x44, 0x1);
        I2CBus.readOnly(dataBuffer, 2);
        int iDistance = dataBuffer[0] << 8 | dataBuffer[1];
        return iDistance;
=======

        I2CBuss.write(0x44, 0x1);
        I2CBuss.readOnly(dataBuffer, 2);
        ByteBuffer bbConvert = ByteBuffer.wrap(dataBuffer);
        return bbConvert.getShort();
>>>>>>> Add working Lidar
    }
}