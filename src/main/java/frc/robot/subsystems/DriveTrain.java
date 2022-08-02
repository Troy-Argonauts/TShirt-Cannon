// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.sensors.SensorInitializationStrategy;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase
{
    private TalonFX frontLeft, frontRight, rearLeft, rearRight;

    public DriveTrain() {
        frontLeft = new TalonFX(Constants.Drivetrain.FRONT_LEFT);
        frontRight = new TalonFX(Constants.Drivetrain.FRONT_RIGHT);
        rearLeft = new TalonFX(Constants.Drivetrain.REAR_LEFT);
        rearRight = new TalonFX(Constants.Drivetrain.REAR_RIGHT);

        frontLeft.setSensorPhase(false);
        frontRight.setSensorPhase(false);
        rearLeft.setSensorPhase(false);
        rearRight.setSensorPhase(false);

        frontLeft.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, 0, 50);
        frontRight.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, 0, 50);
        rearLeft.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, 0, 50);
        rearRight.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, 0, 50);

        frontRight.configFeedbackNotContinuous(false, 4);
        frontLeft.configFeedbackNotContinuous(false, 4);
        rearLeft.configFeedbackNotContinuous(false, 4);
        rearRight.configFeedbackNotContinuous(false, 4);

        frontRight.configOpenloopRamp(Constants.DriveTrain.RAMP_SECONDS);
        frontLeft.configOpenloopRamp(Constants.DriveTrain.RAMP_SECONDS);
        rearRight.configOpenloopRamp(Constants.DriveTrain.RAMP_SECONDS);
        rearLeft.configOpenloopRamp(Constants.DriveTrain.RAMP_SECONDS);
        frontRight.configClosedloopRamp(Constants.DriveTrain.RAMP_SECONDS);
        frontLeft.configClosedloopRamp(Constants.DriveTrain.RAMP_SECONDS);
        rearRight.configClosedloopRamp(Constants.DriveTrain.RAMP_SECONDS);
        rearLeft.configClosedloopRamp(Constants.DriveTrain.RAMP_SECONDS);

        frontRight.configIntegratedSensorInitializationStrategy(SensorInitializationStrategy.BootToAbsolutePosition);
        frontLeft.configIntegratedSensorInitializationStrategy(SensorInitializationStrategy.BootToAbsolutePosition);

        rearLeft.follow(frontLeft);
        rearRight.follow(frontRight);

        frontLeft.setInverted(true);
        rearLeft.setInverted(InvertType.FollowMaster);
        frontRight.setInverted(false);
        rearRight.setInverted(InvertType.FollowMaster);

        frontLeft.setNeutralMode(NeutralMode.Coast);
        frontRight.setNeutralMode(NeutralMode.Coast);
        rearLeft.setNeutralMode(NeutralMode.Coast);
        rearRight.setNeutralMode(NeutralMode.Coast);

    }

    public static void cheesyDrive(double turn, double speed, double nerf) {
        frontLeft.set(ControlMode.PercentOutput, (nerf + speed) * nerf);
        frontRight.set(ControlMode.PercentOutput, (nerf - speed) * nerf);
    }
}
