curl -d "@cards.json" -H "Content-Type: application/json" -X POST http://localhost:8081/mtgdb/cards
curl -d "@sets.json" -H "Content-Type: application/json" -X POST http://localhost:8081/mtgdb/sets
curl -d "@formats.json" -H "Content-Type: application/json" -X POST http://localhost:8081/mtgdb/formats

for i in {1..13}
do
    curl -d "@Relationships/CardsToSets/$i.json" -H "Content-Type: application/json" -X PUT http://localhost:8081/mtgdb/cards/$i
done

for j in {14..17}
do
    curl -d "@Relationships/SetsToFormats/$j.json" -H "Content-Type: application/json" -X PUT http://localhost:8081/mtgdb/format/$j
done