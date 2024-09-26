package com.marsrover.service;

import com.marsrover.model.AbstractRover;
import com.marsrover.model.JumpingRover;
import com.marsrover.model.StandardRover;
import com.marsrover.model.Plateau;
import com.marsrover.model.Orientation;

public class RoverFactoryImpl implements RoverFactory {
    @Override
    public AbstractRover createRover(String id, int x, int y, Orientation orientation, Plateau plateau, String type) {
        switch (type.toLowerCase()) {
            case "standard":
                return new StandardRover(id, x, y, orientation, plateau);
            case "jumping":
                return new JumpingRover(id, x, y, orientation, plateau);
            default:
                throw new IllegalArgumentException("Unknown rover type: " + type);
        }
    }
}
