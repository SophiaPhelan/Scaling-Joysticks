package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.Drive;

/**
 * An example subsystem. You can replace me with your own Subsystem.
 */
public class Drivetrain extends Subsystem {

  private CANSparkMax leftMaster, rightMaster, leftFollower1, leftFollower2, rightFollower1, rightFollower2;

  private double leftNyoom, rightNyoom;

  public Drivetrain() {

    leftMaster = new CANSparkMax(0, MotorType.kBrushless);
    leftFollower1 = new CANSparkMax(1, MotorType.kBrushless);
    leftFollower2 = new CANSparkMax(2, MotorType.kBrushless);
    rightMaster = new CANSparkMax(3, MotorType.kBrushless);
    rightFollower1 = new CANSparkMax(4, MotorType.kBrushless);
    rightFollower2 = new CANSparkMax(5, MotorType.kBrushless);

  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new Drive());
  }

  public void arcadeDrive(double throttle, double turn, boolean squaredInputs) {

    if (squaredInputs) {
      // square the inputs (while preserving the sign) to increase fine control
      // while permitting full power
      throttle = Math.abs(throttle) * throttle;
      turn = Math.abs(turn) * turn;

    }

    leftNyoom = throttle - turn;
    rightNyoom = throttle + turn;

    leftMaster.set(leftNyoom);
      leftFollower1.set(leftNyoom);
      leftFollower2.set(leftNyoom);
    rightMaster.set(rightNyoom);
      rightFollower1.set(rightNyoom);
      rightFollower2.set(rightNyoom);
    
	}

}