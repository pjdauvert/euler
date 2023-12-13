package net.pj.games.eulerproject;

import java.math.BigInteger;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * Classe utilitaire pour le traitement des Matrices
 * </p>
 * @author dauvertpj
 */
public class MatrixUtils {
	
	private static final Logger log = LoggerFactory.getLogger(MatrixUtils.class);
	
	public static String printMatrix(BigInteger[][] matrix) {

		final String CR = "\n";
		final String TAB = " ";
		final StringBuilder out = new StringBuilder("\n");
		//final int matrixHeight = matrix.length;
		final int matrixLength = matrix[0].length;
		
		//calcul de la valeur max
		BigInteger maxValue = BigInteger.ZERO;
        for (BigInteger[] bigIntegers : matrix) {
            for (int j = 0; j < matrixLength; j++) {
                if (bigIntegers[j].compareTo(maxValue) > 0) maxValue = bigIntegers[j];
            }
        }
		//calcul du span
		int span = maxValue.toString().length();
		
		//mise en forme de la Matrice dans le buffer		
        for (BigInteger[] bigIntegers : matrix) {
            for (int j = 0; j < matrixLength; j++) {
                out.append(StringUtils.leftPad(bigIntegers[j].toString(), span));
                if (j != matrixLength - 1) {
                    out.append(TAB);
                } else {
                    out.append(CR);
                }
            }
        }
		return out.toString();
	}
	
	public static int[][] getMatrixFromString(String input, int lenght, int height){
		
		int[][] matrix = new int[height][lenght];
		String[] inputSplit = input.split("\\s");
		if(inputSplit.length != lenght*height)
			log.warn("Number of element in input parameters differs from matrix size");
		int line, column;
		for(int i = 0; i< inputSplit.length && i< lenght*height; i++){
			line = (i)/lenght;
			column = i-(line*lenght);
			matrix[line][column]= Integer.parseInt(inputSplit[i]);
		}
		return matrix;
	}
	
	public static BigInteger[][] translateToBigInteger(int[][] matrix){
		
		final int matrixHeight = matrix.length;
		final int matrixLenght = matrix[0].length;
		final BigInteger[][] bigMatrix = new BigInteger[matrixHeight][matrixLenght];
		
		for (int i = 0; i < matrixHeight; i++) {
			for (int j = 0; j < matrixLenght; j++) {
				bigMatrix[i][j] = new BigInteger(String.valueOf(matrix[i][j]));
			}
		}
		return bigMatrix;
		
		
	}

}
