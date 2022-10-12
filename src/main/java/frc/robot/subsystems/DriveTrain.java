// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.sensors.SensorInitializationStrategy;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase
{
    private static TalonSRX frontLeft, frontRight, rearLeft, rearRight;

    public DriveTrain() {
        frontLeft = new TalonSRX(Constants.DriveTrain.FRONT_LEFT);
        frontRight = new TalonSRX(Constants.DriveTrain.FRONT_RIGHT);
        rearLeft = new TalonSRX(Constants.DriveTrain.REAR_LEFT);
        rearRight = new TalonSRX(Constants.DriveTrain.REAR_RIGHT);

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

        rearRight.follow(frontRight);
        rearLeft.follow(frontLeft);

        frontLeft.setInverted(true);
        rearLeft.setInverted(InvertType.FollowMaster);
        frontRight.setInverted(false);
        rearRight.setInverted(InvertType.FollowMaster);

        frontLeft.setNeutralMode(NeutralMode.Coast);
        frontRight.setNeutralMode(NeutralMode.Coast);
        rearLeft.setNeutralMode(NeutralMode.Coast);
        rearRight.setNeutralMode(NeutralMode.Coast);
    }

    public void cheesyDrive(double turn, double speed, double nerf) {
        frontLeft.set(ControlMode.PercentOutput, (speed - turn) * nerf);
        frontRight.set(ControlMode.PercentOutput, (speed + turn) * nerf);
    }

    public void tankDrive(double left, double right, double nerf) {
        frontLeft.set(ControlMode.PercentOutput, left * nerf);
        frontRight.set(ControlMode.PercentOutput, right * nerf);
    }
}
