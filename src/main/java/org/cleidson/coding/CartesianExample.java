package org.cleidson.coding;

import java.util.ArrayList;
import java.util.List;

/**
# Challenge
As efficiently as possible, find the nearest bus stop for a given (cartesian) geo coordinate.

# Example Data

## Your position
590 230

## Bus stops
* 600 400
* 595 200
* 400 260
* 100 200

## Expected result
595 200
*/
public class CartesianExample {

    public static void main(String[] args) {

        PositionDto positionOne = new PositionDto(595, 200);
        PositionDto positionTwo = new PositionDto(400, 260);

        // TODO - review ArrayList or LinkedList
        List<PositionDto> busPositionDtoList = new ArrayList<>();
        busPositionDtoList.add(positionOne);
        busPositionDtoList.add(positionTwo);

        PositionDto myPosition = new PositionDto(590, 260);

        PositionDto resultNearestPosition =  gettingNearestPosition(myPosition, busPositionDtoList);

        System.out.println(resultNearestPosition);
    }

    /**
     * d=√( (x_2 - x_1)² + (y_2 - y_1)² )
     */
    private static PositionDto gettingNearestPosition(PositionDto myPosition, List<PositionDto> possiblePositions) {
        Integer valueX = null;
        Integer valueY = null;

        double nearestDistance = Double.MAX_VALUE;
        double auxDistanceResult = 0.0;
        PositionDto nearestPositionResult = null;

        for(PositionDto position : possiblePositions) {
            valueX = (position.left - myPosition.left);
            valueY = (position.right - myPosition.right);

            // The calc is: Square Root of (x2 - x1)² + (y2 + y1)²
            // Because of this, it is (valueY * valueY) and (valueX * valueX)
            // It can also use Math.pow(valueY, 2)
            auxDistanceResult = Math.sqrt( (valueY * valueY) + (valueX * valueX));
//            auxDistanceResult = Math.sqrt( Math.pow(valueY, 2) + Math.pow(valueX, 2));

            if(auxDistanceResult < nearestDistance) {
                nearestDistance = auxDistanceResult;
                nearestPositionResult = position;
            }
        }

        return nearestPositionResult;
    }

    private record PositionDto(int left, int right) {
        @Override
        public String toString() {
            return "PositionDto{" +
                    "left='" + left + '\'' +
                    ", right='" + right + '\'' +
                    '}';
        }
    }
}
