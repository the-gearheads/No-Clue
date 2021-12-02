// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.SS_Drive;

public class C_ArcadeDrive extends CommandBase {
  public SS_Drive SS_drive;

  /** Creates a new C_ArcadeDrive. */
  public C_ArcadeDrive(SS_Drive SS_drive) {
   // Use addRequirements() here to declare subsystem dependencies.
   this.SS_drive = SS_drive;
   addRequirements(SS_drive);
 }

 // Called when the command is initially scheduled.
 @Override
 public void initialize() {}

 // Called every time the scheduler runs while the command is scheduled.
 @Override
 public void execute() {
   double lvAxis = DriverStation.getInstance().getStickAxis(Constants.CONTROLLER_PORT, Constants.LV_AXIS);
   double rhAxis = DriverStation.getInstance().getStickAxis(Constants.CONTROLLER_PORT, Constants.RH_AXIS);
   SS_drive.arcadeDrive(lvAxis,rhAxis);
 }

 // Called once the command ends or is interrupted.
 @Override
 public void end(boolean interrupted) {
  SS_drive.arcadeDrive(0,0);
 }

 // Returns true when the command should end.
 @Override
 public boolean isFinished() {
   return false;
 }
}
