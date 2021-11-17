// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.SS_Drive;

public class C_TankDrive extends CommandBase {
  /** Creates a new DriveC. */
  private SS_Drive driveSS;
  public C_TankDrive(SS_Drive driveSS) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.driveSS = driveSS;
    addRequirements(driveSS);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //Code to make the shaft start at the bottom
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double rvAxis = DriverStation.getInstance().getStickAxis(Constants.CONTROLLER_PORT, Constants.RV_AXIS);
    double lvAxis = DriverStation.getInstance().getStickAxis(Constants.CONTROLLER_PORT, Constants.LV_AXIS);
    driveSS.setTankDrive(rvAxis, lvAxis);
    //
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveSS.setTankDrive(0,0);
    //After the shaft is half-extended, 
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}