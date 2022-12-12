def sum_first_and_last_digit(number: int):
    if number < 0:
        return -1;
    elif number < 9:
        return number * 2
    str_number = str(number);
    last_digit = str_number[len(str_number) - 1];
    first_digit = str_number[0];
    return int(first_digit) + int(last_digit);



print(sum_first_and_last_digit(121))
print(sum_first_and_last_digit(-121))
print(sum_first_and_last_digit(6))
print(sum_first_and_last_digit(1234567))
