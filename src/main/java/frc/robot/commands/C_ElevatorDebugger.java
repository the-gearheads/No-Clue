// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.ElevatorFeedforward;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.ProfiledPIDSubsystem;
import frc.robot.subsystems.SS_Elevator2;

public class C_ElevatorDebugger extends CommandBase {
  private SS_Elevator2 SS_elevator;

  /** Creates a new C_SetElevatorByHeight3. */
  public C_ElevatorDebugger(SS_Elevator2 SS_elevator) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.SS_elevator = SS_elevator;
    SS_elevator.enable();
    addRequirements(SS_elevator);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    SmartDashboard.putNumber("Elevator kP", 0);
    SmartDashboard.putNumber("Elevator kD", 0);

    SmartDashboard.putNumber("Elevator FeedForward kS", 0);
    SmartDashboard.putNumber("Elevator FeedForward kG", 0);
    SmartDashboard.putNumber("Elevator FeedForward kV", 0);
    SmartDashboard.putNumber("Elevator FeedForward kA", 0);
    SmartDashboard.putNumber("Elevator kD", 0);
    SmartDashboard.putNumber("Elevator kD", 0);

    SmartDashboard.putNumber("Elevator Setpoint", 0);
    SmartDashboard.putNumber("Elevator Position", SS_elevator.getMeasurement());
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
   
      SS_elevator.getController().setP(SmartDashboard.getNumber("Elevator kP",0));
    
      SS_elevator.getController().setD(SmartDashboard.getNumber("Elevator kD",0));
    
    if(true){
      SS_elevator.setFeedForward(new ElevatorFeedforward(SmartDashboard.getNumber("Elevator Feedforward kS", 0),
                                                         SmartDashboard.getNumber("Elevator Feedforward kG", 0), 
                                                         SmartDashboard.getNumber("Elevator Feedforward kV", 0),
                                                         SmartDashboard.getNumber("Elevator Feedforward kA", 0)));

    }

    SmartDashboard.putNumber("Feedforward values", SS_elevator.getFeedForward().ks);

      SS_elevator.setGoal(SmartDashboard.getNumber("Elevator Setpoint",0));
  
    SmartDashboard.putNumber("Elevator Position", SS_elevator.getMeasurement());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
