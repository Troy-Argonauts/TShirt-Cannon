// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.*;
import frc.libs.util.*;



/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
    public static ArgoController driver;

    public RobotContainer() {
        driver = new ArgoController(Constants.Controller.DRIVER_PORT);

        configureButtonBindings();
    }

    private void configureButtonBindings() {
        Robot.getDriveTrain().setDefaultCommand(
                new RunCommand(() -> {
                    Robot.getDriveTrain().cheesyDrive(driver.getRightJoystickX(), driver.getLeftJoystickY(), 0.8);
                }, Robot.getDriveTrain())
        );

        driver.getBButton()
                .whenActive(new InstantCommand(() -> Robot.getPneumatics().set(true)))
                .whenInactive(new InstantCommand(() -> Robot.getPneumatics().set(false)));
        }

}
