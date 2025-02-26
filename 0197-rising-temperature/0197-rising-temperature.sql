/* Write your PL/SQL query statement below */
SELECT id 
FROM (
    SELECT id, recordDate, temperature, 
            LAG(temperature, 1) OVER (ORDER BY recordDate) as previousDayTemp,
            LAG(recordDate) OVER (ORDER BY recordDate) AS previousDayDate
    FROM Weather
) WeatherLagTable
WHERE WeatherLagTable.temperature > WeatherLagTable.previousDayTemp 
        AND WeatherLagTable.recordDate = WeatherLagTable.previousDayDate + INTERVAL '1' DAY
ORDER BY id;