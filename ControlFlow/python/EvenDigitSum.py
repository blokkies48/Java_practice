def even_digit_sum(number: int):
    if number < 0:
        return -1;
    return_sum = 0;
    while number > 0:
        if (number % 10) % 2 == 0: 
            return_sum += number % 10;
        number = int(number / 10);
    return return_sum;


print(even_digit_sum(10))
print(even_digit_sum(222))
print(even_digit_sum(-10))
print(even_digit_sum(2000004000002))