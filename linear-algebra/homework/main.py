import sympy as sp


def make_A(a):
    """creates a new matrix for each value of a"""
    return sp.Matrix([[-6, 28, 21], [4, -15, -12], [-8, a, 25]])


list_a = [32, 31.9, 31.8, 32.1, 32.2]  # different values of a
plots = []  # store plots
t = sp.symbols("t")  # creates a t symbol
lamda = sp.symbols("lamda")  # creates a lambda symbol

for i in list_a:
    A = make_A(i)
    size = A.rank()
    char_poly = A.charpoly(lamda)  # calculates the characteristic polynomial
    print("a:", i, ",", char_poly)
    print("eigen values:", A.eigenvals())

    print()

    # plot det(A -tI), 0 <= t <= 3
    # store plots on the same axis
    if plots:
        plots[0].append(
            sp.plot(
                (A - (t * sp.eye(size))).det(),
                (t, 0, 3),
                show=False,
                label="a = {0}".format(i)
            )[0]
        )
    else:
        plots.append(
            sp.plot(
                (A - (t * sp.eye(size))).det(),
                (t, 0, 3),
                show=False,
                title="Graph of Characteristic Polynomials",
                ylabel="p(t) = det(A - tI)",
                legend=True,
                label="a = {0}".format(i)
            )
        )

plots[0].show()  # display plot
