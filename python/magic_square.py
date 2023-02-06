def get_user_input() -> int:
    '''
    function used to get user input

    param: None
    return: int - a positive odd integer
    '''
    while True:
        try:
            user_input: int = int(input("Enter a positive odd int: "))
            if user_input % 2 != 0:
                return user_input # int value returned
            else:
                raise ValueError
        except ValueError:
            print("Invalid input...")

def generate_grid(grid_size: int) -> list[list[int]]:
    '''
    function used to get grid

    param: int - enter the side sizes of the grid
    return: list[list[int]] - a 2d list of the gird
    '''
    return_grid: list[int] = []
    for _ in range(grid_size):
        return_grid.append([0 for _ in range(grid_size)])
    return return_grid


def magic_square(grid_size: int) -> list[list[int]]:
    '''
    function fills in grid 

    param: int - size of the grid single int
    return: list[list[int]] - filled in 2d list (magic square)
    '''
    # Creating grid
    grid: list[list[int]] = generate_grid(grid_size)

    # Initial position of x and y 
    x_coordinate: int = 0
    y_coordinate: int = int(grid_size/2)

    # Initial position of 1
    grid[x_coordinate][y_coordinate] = 1

    # Loop used to get all the values to be placed
    for value in range(2, (grid_size ** 2) + 1):
    
        # If outside of row and inside col
        if (x_coordinate - 1 < 0 and y_coordinate + 1 < grid_size):
            x_coordinate = grid_size -1
            y_coordinate += 1
            grid[x_coordinate][y_coordinate] = value

        # If inside row and outside col 
        elif (x_coordinate - 1 >= 0 and y_coordinate + 1 >= grid_size):
            x_coordinate -= 1
            y_coordinate = 0
            grid[x_coordinate][y_coordinate] = value

        # If outside row and column
        elif (x_coordinate - 1 < 0 and y_coordinate + 1 >= grid_size):
            x_coordinate += 1
            grid[x_coordinate][y_coordinate] = value

        # If position is taken
        elif (grid[x_coordinate - 1][y_coordinate + 1] != 0):
            x_coordinate += 1
            grid[x_coordinate][y_coordinate] = value

        # If position isn't taken
        elif (grid[x_coordinate - 1][y_coordinate + 1] == 0):
            x_coordinate -= 1
            y_coordinate += 1
            grid[x_coordinate][y_coordinate] = value

    return grid

def print_grid(finished_grid: list[list[int]]) -> None:
    '''
    bonus function to print grid nicely.
    param: list[list[int]] - the filled in grid
    return: None
    '''
    # Adds zeroes in front of values to smooth out the output.
    print(f"\nThis square contains {len(finished_grid)**2} values")
    print(f"and is {len(finished_grid)} x {len(finished_grid)} in size")
    for row in finished_grid:
        # Go to next line
        print()
        for value in row:
            # Compares amount of digits.
            if len(str(value)) < len(str(max(row))):
                # The more the digits the less zeroes needed.
                print(("0" * (len(str(max(row))) - len(str(value))))+ str(value), end=" ")
            else:
                print(str(value), end=" ")
    print()

def verification_check(grid: list[list[int]]) -> bool:
    '''
    Checks if valid magic square
    param: list[list[int]] - the magic square
    return: bool - True if valid else False 
    '''
    control_value: int = sum(grid[0])
    # Test horizontal (rows)
    for index, row in enumerate(grid):
        if sum(row) != control_value:
            return False

        # Testing vertical (columns)
        values: list[int] = []
        for row_index in range(len(grid)):
            values.append(grid[row_index][index])
        if sum(values) != control_value:
            return False

    # Testing cross left to right down.
    cross_values: list[int] = []
    for i in range(len(grid)):
        cross_values.append(grid[i][i])
    if sum(cross_values) != control_value:
        return False

    # Testing cross right to left down.
    cross_values: list[int] = []
    index_top_value = len(grid) - 1
    for i in range(len(grid)):
        cross_values.append(grid[i][index_top_value - i])
    if sum(cross_values) != control_value:
        return False

    # Passing all tests will return true.
    return True


def main() -> None:
    # Set up
    user_input = get_user_input()
    the_finished_product = magic_square(user_input)

    # Print magic square.
    print_grid(the_finished_product)

    # Print validation
    if verification_check(the_finished_product):
        print("\nThis is a valid magic square...")
    else:
        print("\nThis is an invalid magic square")

if __name__ == "__main__":
    main()