package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.C_SetElevatorByAxis;
import frc.robot.commands.C_SetElevatorByHeight;

public class SS_Elevator extends SubsystemBase {
  private final CANSparkMax elevatorMotor;
  private final CANEncoder heightEncoder;
  private double goal = 0;
  private double speed = Constants.Elevator.SPEED;
  /** Creates a new ExampleSubsystem. */
  public SS_Elevator() {
      elevatorMotor =  new CANSparkMax(Constants.Elevator.MOTOR_ID, MotorType.kBrushless);
      heightEncoder = elevatorMotor.getEncoder();

      heightEncoder.setPosition(0);
      heightEncoder.setPositionConversionFactor(Constants.Elevator.ROTATIONS_TO_METERS);
      
      setDefaultCommand(new C_SetElevatorByAxis(this));
  }

  
  public void setSpeed(double speed){
    elevatorMotor.set(speed);
  }
  public void setGoal(double goal){
    if(goal < Constants.Elevator.MAX_HEIGHT && goal >= Constants.Elevator.MIN_HEIGHT){
      this.goal = goal;
    }else{
      SmartDashboard.putString("ERROR", "Attempted to set goal greater than max or less than min. Attempted Goal: " + goal);
    }
  }
  
  public double getHeight(){
    return heightEncoder.getPosition();
  }
  public double getSpeed(){
    return elevatorMotor.get();
  }
  public double getGoal(){
    return goal;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    if(Math.abs(getHeight() - goal) < 0.01){
      setSpeed(0);
    }else if(getHeight() < goal && getHeight() < Constants.Elevator.MAX_HEIGHT){
      setSpeed(speed);
    }else if(getHeight() > goal && getHeight() > Constants.Elevator.MIN_HEIGHT){
      setSpeed(-speed);
    }
    
    SmartDashboard.putNumber("Elevator Position", getHeight());
    SmartDashboard.putNumber("Elevator Goal: ", getGoal());
    SmartDashboard.putNumber("Elevator Speed: ", getSpeed());
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
