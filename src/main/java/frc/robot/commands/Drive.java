package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;

public class Drive extends Command {

    public Drive() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    	//read in joystick values from OI
		//range [-1, 1]
		//processing if we wanted to do things to it - we don't - this is excess code
    	double throttleInput = throttleInputProcessing(OI.getInstance().getThrottle());
		double turnInput = turnInputProcessing(OI.getInstance().getTurn());
		
 
    	//find the maximum possible value of (throttle + turn)
    	//along the vector that the arcade joystick is pointing
    	double saturatedInput;
    	double greaterInput = Math.max(Math.abs(throttleInput), Math.abs(turnInput));
    		//range [0, 1]
    	double lesserInput = Math.abs(throttleInput) + Math.abs(turnInput) - greaterInput;
    		//range [0, 1]
    	if (greaterInput > 0.0) {
    		saturatedInput = (lesserInput / greaterInput) + 1.0;
       		//range [1, 2]
    	} else {
    		saturatedInput = 1.0;
    	}
     	
    	//scale down the joystick input values
		//such that (throttle + turn) always has a range [-1, 1]
    	throttleInput = throttleInput / saturatedInput;
		turnInput = turnInput / saturatedInput;
		
		double left = leftOutputProcessing(throttleInput); 	//same as processing earlier
		double right = rightOutputProcessing(turnInput);

	    Robot.drivetrain.arcadeDrive(left, right, false);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }
	
	/**
	 * Post processing on the left output value prior to sending to Robot.drivetrain
	 */
	protected double leftOutputProcessing(double left) {
		return left;
	}

	/**
	 * Post processing on the left output value prior to sending to Robot.drivetrain
	 */
	protected double rightOutputProcessing(double right) {
		return right;
	}

	/**
	 * Pre processing on the throttle input value prior to normalizing
	 */
	protected double throttleInputProcessing(double throttle) {
		return throttle;
	}

	/**
	 * Pre processing on the turn input value prior to normalizing
	 */
	protected double turnInputProcessing(double turn) {
		return turn;
	}
}