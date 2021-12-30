// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.C_TankDrive;
import frc.robot.commands.C_ArcadeDrive;
public class SS_Claw extends SubsystemBase {

  private final CANSparkMax clawMotor;
  private final CANEncoder clawEncoder;

  /** Creates a new ExampleSubsystem. */
  public SS_Claw() {
      clawMotor = new CANSparkMax(Constants.Claw.MOTOR_ID, MotorType.kBrushless);
      clawEncoder = clawMotor.getEncoder();
      clawEncoder.setPosition(0);
  }

  public double getPosition(){
    return clawEncoder.getPosition();
  }

  public void setSpeed(double speed){
    clawMotor.set(speed);
  }
  public double getSpeed(){
    return clawMotor.get();
  }
  public double getCurrent(){
    return clawMotor.getOutputCurrent();
  }

  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}