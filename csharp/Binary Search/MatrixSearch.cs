﻿public class Solution
{
	public bool MatrixSearch(int[][] matrix, int target)
	{
		int m = matrix.Length, n = matrix[0].Length;
		int left = 0, right = m * n - 1;

		// Perform binary search to find the target.
		while (left <= right)
		{
			int mid = (left + right) / 2;
			int r = mid / n, c = mid % n;

			if (matrix[r][c] == target)
				return true;

			if (matrix[r][c] > target)
				right = mid - 1;
			else
				left = mid + 1;
		}

		return false;
	}
}
