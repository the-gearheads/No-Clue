package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.C_SetShaftByAxis;

public class SS_Shaft extends SubsystemBase {

  private final CANSparkMax shaftMotor;
  private final CANEncoder heightEncoder;
  /** Creates a new ExampleSubsystem. */
  public SS_Shaft() {
      shaftMotor =  new CANSparkMax(Constants.SHAFT_MOTOR, MotorType.kBrushless);
      heightEncoder = shaftMotor.getEncoder();
      setDefaultCommand(new C_SetShaftByAxis(this));
    //   heightEncoder.setPositionConversionFactor(Constants.SHAFT_ROTATIONS_TO_METERS);
  }

  public double getHeight(){
    return heightEncoder.getPosition();
  }

  public void setSpeed(double speed){
    shaftMotor.set(speed);
  }

  @Override
  public void periodic() {
        System.out.println("Height: " + getHeight());
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
