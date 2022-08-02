// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

public final class Constants {
    public interface Drivetrain {
        int FRONT_LEFT = 1;
        int FRONT_RIGHT = 2;
        int REAR_LEFT = 3;
        int REAR_RIGHT = 4;
        double RAMP_SECONDS = 0.75;
    }

    public interface Controller {
        int DRIVER_PORT = 0;
        double CONTROLLER_DRIFT = 0.1;
    }
}
