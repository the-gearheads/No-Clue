// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import javax.sound.sampled.SourceDataLine;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.C_TankDrive;
import frc.robot.commands.C_ArcadeDrive;
import frc.robot.commands.C_DebugDrive;
public class SS_Drive extends SubsystemBase {

  private final CANSparkMax lfMotor;
  private final CANSparkMax rfMotor;
  private final CANSparkMax lbMotor;
  private final CANSparkMax rbMotor;
  private final CANEncoder lfEncoder;
  private final CANEncoder rfEncoder;
  private final CANEncoder lbEncoder;
  private final CANEncoder rbEncoder;
  private final SpeedControllerGroup leftMotors;
  private final SpeedControllerGroup rightMotors;
  private DifferentialDrive differentialDrive;
  private double prevLBPos = 0;
  private double prevLFPos = 0;
  private double prevRBPos = 0;
  private double prevRFPos = 0;

  /** Creates a new ExampleSubsystem. */
  public SS_Drive() {
    rfMotor = new CANSparkMax(Constants.RF_ID, MotorType.kBrushless);
    rbMotor = new CANSparkMax(Constants.RB_ID, MotorType.kBrushless);
    lfMotor = new CANSparkMax(Constants.LF_ID, MotorType.kBrushless);
    lbMotor = new CANSparkMax(Constants.LB_ID, MotorType.kBrushless);
    
    rfMotor.setInverted(true);
    rbMotor.setInverted(true);
    lbMotor.setInverted(false);

    rfMotor.setIdleMode(IdleMode.kBrake);
    rbMotor.setIdleMode(IdleMode.kBrake);
    lfMotor.setIdleMode(IdleMode.kBrake);
    lbMotor.setIdleMode(IdleMode.kBrake);
    
    rfEncoder = rfMotor.getEncoder();
    rbEncoder = rbMotor.getEncoder();
    lfEncoder = lfMotor.getEncoder();
    lbEncoder = lbMotor.getEncoder();
    
    rfEncoder.setPosition(0);
    rbEncoder.setPosition(0);
    lfEncoder.setPosition(0);
    lbEncoder.setPosition(0);

    rightMotors = new SpeedControllerGroup(rfMotor, rbMotor);
    leftMotors = new SpeedControllerGroup(lfMotor, lbMotor);
    differentialDrive = new DifferentialDrive(leftMotors, rightMotors);
    setDefaultCommand(new C_ArcadeDrive(this));
  }
 
  public void setRF(double speed){
    rfMotor.set(speed);
  }
  public void setRB(double speed){
    rbMotor.set(speed);
  }
  public void setLF(double speed){
    lfMotor.set(speed);
  }
  public void setLB(double speed){
    lbMotor.set(speed);
  }
  
  public double getRFPosition(){
    return rfEncoder.getPosition();
  }
  public double getRBPosition(){
    return rbEncoder.getPosition();
  }
  public double getLFPosition(){
    return lfEncoder.getPosition();
  }
  public double getLBPosition(){
    return lbEncoder.getPosition();
  }
  
  public void setRight(double speed){
    rightMotors.set(speed);
  }
  public void setLeft(double speed){
    leftMotors.set(speed);
  }

  public void setTankDrive(double rightSpeed, double leftSpeed){
    leftMotors.set(-leftSpeed);
    rightMotors.set(-rightSpeed);
  }
  public void arcadeDrive(double speed, double rotation){
    differentialDrive.arcadeDrive(rotation,-speed);
  }

  public void printRPMs(){
    SmartDashboard.putNumber("rfMotor RPM",(getRFPosition() - prevRFPos)/20 * 60000);
    SmartDashboard.putNumber("rbMotor RPM",(getRBPosition() - prevRBPos)/20 * 60000);
    SmartDashboard.putNumber("lfMotor RPM",(getLFPosition() - prevLFPos)/20 * 60000);
    SmartDashboard.putNumber("lbMotor RPM",(getLBPosition() - prevLBPos)/20 * 60000);

    prevLBPos = getLBPosition();
    prevLFPos = getLFPosition();
    prevRBPos = getRBPosition();
    prevRFPos = getRFPosition();
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
