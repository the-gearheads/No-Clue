// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
// REAL COMMAND, DONT USE OTHERS!!!
package frc.robot.OldCode;

import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.ProfiledPIDSubsystem;

public class C_SetElevatorByHeight3 extends CommandBase {
  private double requestedHeight;
  private ProfiledPIDSubsystem SS_elevator;

  /** Creates a new C_SetElevatorByHeight3. */
  public C_SetElevatorByHeight3(SS_Elevator2 SS_elevator, double requestedHeight) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.SS_elevator = SS_elevator;
    this.requestedHeight = requestedHeight;
    SS_elevator.enable();
    addRequirements(SS_elevator);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    SS_elevator.setGoal(new TrapezoidProfile.State(requestedHeight, 0));
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return SS_elevator.getController().atGoal();
  }
}
