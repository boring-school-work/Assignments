# # Import all libraries from sympy
from sympy import Matrix
#
# # create a matrix
# b = Matrix([1, 2, 3])
#
# # show matrix
# print("Column vector b:", b)
#
# # Get the shape
# print("Shape of b:", b.shape)
#
# print()
#
# # create a matrix
# a = Matrix([[1, 2, 3]])
#
# # show matrix
# print("Row vector a:", a)
#
# # Get the shape
# print("Shape of a:", a.shape)
#
#
# print()
#
# # Create a matrix:
# # 1     -2      1
# # 0     2       -8
# # 5     0       -5
# A = Matrix([
#     [1, -2, 1],
#     [0, 2, -8],
#     [5, 0, -5]
# ])
#
# print("Matrix A:", A)
# print("A[row 1, column 2]:", A[0, 1])
#
# # A[row number : acolumn number]
# print("First row of A:", A[0, :])
# print("First column of A:", A[:, 0])
#
# # Use row_del() and col_del() to delete rows and columns
# # Delete first row
# A.row_del(0)
# print("Matrix A after row deletion:", A)
#
# A.col_del(0)
# print("Matrix A after column deletion:", A)

B = Matrix([
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
])

print(B)
# insert a row
B.col_insert(3, Matrix([-1, 2, 7]))
print(B)
