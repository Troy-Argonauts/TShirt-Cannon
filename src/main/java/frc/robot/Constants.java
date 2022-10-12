// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

public final class Constants {
    public interface DriveTrain {
        int FRONT_LEFT = 1;
        int FRONT_RIGHT = 3;
        int REAR_LEFT = 2;
        int REAR_RIGHT = 4;
        double RAMP_SECONDS = 0;
    }

    public interface Pneumatics {
        int SOLENOID_1 = 0;
    }

    public interface Controller {
        int DRIVER_PORT = 0;
        double CONTROLLER_DRIFT = 0.1;
    }

//    public interface Pneumatics {
//        int SOLENOID_1 = 0;
//        int SOLENOID_2 = 1;
//    }
}
