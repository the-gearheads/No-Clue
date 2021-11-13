// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.DriveC;

public class DriveSS extends SubsystemBase {

  private final CANSparkMax lfMotor;
  private final CANSparkMax rfMotor;
  private final CANSparkMax lbMotor;
  private final CANSparkMax rbMotor;
  private final SpeedControllerGroup leftSide;
  private final SpeedControllerGroup rightSide;

  /** Creates a new ExampleSubsystem. */
  public DriveSS(XboxController controller) {
      setDefaultCommand(new DriveC(controller));
      lfMotor = new CANSparkMax(Constants.LF_ID, MotorType.kBrushless);
      rfMotor = new CANSparkMax(Constants.RF_ID, MotorType.kBrushless);
      lbMotor = new CANSparkMax(Constants.LB_ID, MotorType.kBrushless);
      rbMotor = new CANSparkMax(Constants.RB_ID, MotorType.kBrushless);
      leftSide = new SpeedControllerGroup(lfMotor, lbMotor);
      rightSide = new SpeedControllerGroup(rfMotor, rbMotor);
  }
  public void setLeft(double speed){
    leftSide.set(speed);
  }
  public void setRight(double speed){
    rightSide.set(speed);
  }
  public void setBoth(double rightSpeed, double leftSpeed){
    leftSide.set(leftSpeed);
    rightSide.set(rightSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
