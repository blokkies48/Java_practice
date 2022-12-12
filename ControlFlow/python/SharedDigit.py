def has_shared_digit(number1: int, number2: int):
    if (99 < number1 < 10) or (99 < number2 < 10): return False;

    while number1 > 0:
        value = number1 % 10;
        value2 = number2
        
        while value2 > 0:
            if (value == value2 % 10): return True;
            value2 = int(value2 / 10)
        number1 = int(number1 / 10)
    return False;


print(has_shared_digit(12,13))
print(has_shared_digit(22,13))
print(has_shared_digit(9,13))


def has_shared_digit_2(number1: int, number2: int):
    if (99 < number1 < 10) or (99 < number2 < 10): return False;
    for number in str(number1):
        if number in str(number2):
            return True;
    return False;

print(has_shared_digit_2(12,13))
print(has_shared_digit_2(22,13))
print(has_shared_digit_2(9,13))