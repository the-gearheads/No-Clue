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
  /** Creates a new ExampleSubsystem. */
  public SS_Elevator() {
      elevatorMotor =  new CANSparkMax(Constants.ELEVATOR_MOTOR, MotorType.kBrushless);
      heightEncoder = elevatorMotor.getEncoder();
      heightEncoder.setPosition(0);
      heightEncoder.setPositionConversionFactor(Constants.ELEVATOR_ROTATIONS_TO_METERS);
      // setDefaultCommand(new C_SetElevatorByHeight(this, 0.5));
      
  }


  public double getHeight(){
    return heightEncoder.getPosition();
  }

  public void setSpeed(double speed){
    elevatorMotor.set(speed);
  }
  public void setVoltage(double voltage){
    elevatorMotor.setVoltage(voltage);
  }
  public double getSpeed(){
    return elevatorMotor.get();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
        System.out.println("Height: " + getHeight());
        SmartDashboard.putNumber("Elevator Position", getHeight());
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
