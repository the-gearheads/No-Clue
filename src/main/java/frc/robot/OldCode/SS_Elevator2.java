package frc.robot.OldCode;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.ElevatorFeedforward;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj2.command.ProfiledPIDSubsystem;
import edu.wpi.first.math.MathUtil;
import frc.robot.Constants;

public class SS_Elevator2 extends ProfiledPIDSubsystem {
    private final CANSparkMax elevatorMotor = new CANSparkMax(Constants.Elevator.MOTOR_ID, MotorType.kBrushless);
    private final CANEncoder elevatorEncoder = elevatorMotor.getEncoder();
    private ElevatorFeedforward feedforward =
        new ElevatorFeedforward(Constants.Elevator.kS, Constants.Elevator.kG,
                           Constants.Elevator.kV, Constants.Elevator.kA);
  
    /**
     * Create a new ArmSubsystem.
     */
    public SS_Elevator2() {
      super(new ProfiledPIDController(Constants.Elevator.kP, Constants.Elevator.kI, Constants.Elevator.kD, new TrapezoidProfile.Constraints(
          Constants.Elevator.MAX_VEL, Constants.Elevator.MAX_ACC)), 0);
      elevatorEncoder.setPositionConversionFactor(Constants.Elevator.ROTATIONS_TO_METERS);
      elevatorEncoder.setPosition(0);
      getController().setTolerance(0.005);

      setDefaultCommand(new C_ElevatorDebugger(this));
    }
  
    @Override
    public void useOutput(double output, TrapezoidProfile.State setpoint) {
      // Calculate the feedforward from the sepoint
      //   double ff = feedforward.calculate(setpoint.position, setpoint.velocity);
      double kS = SmartDashboard.getNumber("Elevator FeedForward kS", 0);
      double kG = SmartDashboard.getNumber("Elevator FeedForward kG", 0);
      double kV = SmartDashboard.getNumber("Elevator FeedForward kV", 0);
      double kA = SmartDashboard.getNumber("Elevator FeedForward kA", 0);

      ElevatorFeedforward feedforward = new ElevatorFeedforward(kS, kG, kV, kA);
      double ff = feedforward.calculate(setpoint.position, setpoint.velocity);

      // Add the feedforward to the PID output to get the motor output
      elevatorMotor.setVoltage(MathUtil.clamp(output + ff, -12, 12));
      // elevatorMotor.setVoltage(output);
    }
  
    @Override
    public double getMeasurement() {
      return elevatorEncoder.getPosition();
    }

    public ElevatorFeedforward getFeedForward(){
        return feedforward;
    }
    public void setFeedForward(ElevatorFeedforward feedforward){
        this.feedforward = feedforward;
    }
  }
