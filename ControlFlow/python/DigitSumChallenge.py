def sum_digit(value: int):
    return_sum = 0;
    for i in str(value):
        return_sum += int(i);
    return return_sum;

def sum_digit_2(value: int):
    return_sum = 0;
    while 0 < value:
        return_sum += value % 10;
        value = int(value / 10);
    return return_sum;
    

print(sum_digit(10001))

print(sum_digit_2(10001))
