echo "Agregando entidades basicas"
curl -d "@cards.json" -H "Content-Type: application/json" -X POST http://localhost:8081/mtgdb/cards
echo ""
curl -d "@sets.json" -H "Content-Type: application/json" -X POST http://localhost:8081/mtgdb/expansions
echo ""
curl -d "@formats.json" -H "Content-Type: application/json" -X POST http://localhost:8081/mtgdb/formats

echo "Relaciones Card -> Set"
for i in {1..15}
do
    curl -d "@Relationships/CardsToSets/$i.json" -H "Content-Type: application/json" -X PUT http://localhost:8081/mtgdb/cards/$i
echo ""
done

echo "Relaciones Format -> Set"
for j in {16..19}
do
    curl -d "@Relationships/SetsToFormats/$j.json" -H "Content-Type: application/json" -X PUT http://localhost:8081/mtgdb/format/$j
echo ""
done


echo "Consultas Formatos disponibles para una carta - ID 10 y ID 9"
curl localhost:8081/mtgdb/formatsavailableforcard/10 | jq
curl localhost:8081/mtgdb/formatsavailableforcard/09 | jq


echo "Buscar que contenga un string: 'A|a'"
curl localhost:8081/mtgdb/all-card-string/?string="A" | jq
