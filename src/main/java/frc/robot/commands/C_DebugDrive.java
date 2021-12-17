// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.EntryListenerFlags;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SS_Drive;

public class C_DebugDrive extends CommandBase {
  private SS_Drive SS_drive;
  private double prevLBPos = 0;
  private double prevLFPos = 0;
  private double prevRBPos = 0;
  private double prevRFPos = 0;

  /** Creates a new C_DebugDrive. */
  public C_DebugDrive(SS_Drive SS_drive) {
    this.SS_drive = SS_drive;
    addRequirements(SS_drive);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  SmartDashboard.putNumber("lbMotor", 0);
  SmartDashboard.putNumber("lfMotor", 0);
  SmartDashboard.putNumber("rbMotor", 0);
  SmartDashboard.putNumber("rfMotor", 0);
  
  SmartDashboard.putNumber("lbMotor Position",SS_drive.getLBPosition());
  SmartDashboard.putNumber("lfMotor Position",SS_drive.getLFPosition());
  SmartDashboard.putNumber("rbMotor Position",SS_drive.getRBPosition());
  SmartDashboard.putNumber("rfMotor Position",SS_drive.getRFPosition());
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute(){
    SmartDashboard.putNumber("lbMotor Position",(SS_drive.getLBPosition() - prevLBPos)/20 * 60000);
    SmartDashboard.putNumber("lfMotor Position",(SS_drive.getLFPosition() - prevLFPos)/20 * 60000);
    SmartDashboard.putNumber("rbMotor Position",(SS_drive.getRBPosition() - prevRBPos)/20 * 60000);
    SmartDashboard.putNumber("rfMotor Position",(SS_drive.getRFPosition() - prevRFPos)/20 * 60000);
    prevLBPos = SS_drive.getLBPosition();
    prevLFPos = SS_drive.getLFPosition();
    prevRBPos = SS_drive.getRBPosition();
    prevRFPos = SS_drive.getRFPosition();

    if(SmartDashboard.getNumber("lbMotor", 0) >= -1 && SmartDashboard.getNumber("lbMotor", 0) <= 1){
      SS_drive.setLB(SmartDashboard.getNumber("lbMotor",0));
    }
    if(SmartDashboard.getNumber("lfMotor", 0) >= -1 && SmartDashboard.getNumber("lfMotor", 0) <= 1){
      SS_drive.setLF(SmartDashboard.getNumber("lfMotor",0));
    }
    if(SmartDashboard.getNumber("rbMotor", 0) >= -1 && SmartDashboard.getNumber("rbMotor", 0) <= 1){
      SS_drive.setRB(SmartDashboard.getNumber("rbMotor",0));
    }
    if(SmartDashboard.getNumber("rfMotor", 0) >= -1 && SmartDashboard.getNumber("rfMotor", 0) <= 1){
      SS_drive.setRF(SmartDashboard.getNumber("rfMotor",0));
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    SmartDashboard.delete("lbMotor");
    SmartDashboard.delete("lfMotor");
    SmartDashboard.delete("rbMotor");
    SmartDashboard.delete("rfMotor");
    
    SmartDashboard.delete("lbMotor Position");
    SmartDashboard.delete("lfMotor Position");
    SmartDashboard.delete("rbMotor Position");
    SmartDashboard.delete("rfMotor Position");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
