// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import javax.sound.sampled.SourceDataLine;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.SS_Drive;

public class C_TankDrive extends CommandBase {
  /** Creates a new DriveC. */
  private SS_Drive SS_drive;
  private final double speedModifier = 0.5;
  public C_TankDrive(SS_Drive SS_drive) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.SS_drive = SS_drive;
    addRequirements(SS_drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //Code to make the shaft start at the bottom
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double rvAxis = DriverStation.getStickAxis(Constants.Controller.PORT, Constants.Controller.RV_AXIS);
    double lvAxis = DriverStation.getStickAxis(Constants.Controller.PORT, Constants.Controller.LV_AXIS);
    // System.out.println("rvAxis: " + rvAxis);
    // System.out.println("lvAxis: " + lvAxis);
    SS_drive.setTankDrive(rvAxis*speedModifier, lvAxis*speedModifier);
    //
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    SS_drive.setTankDrive(0,0);
    //After the shaft is half-extended, 
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
