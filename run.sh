#!/bin/bash

# bikin folder build kalau belum ada
mkdir -p build

# compile semua java dari amerika/ dan app/ ke build/
javac -d build amerika/**/*.java app/**/*.java

# cek kalau compile berhasil
if [ $? -eq 0 ]; then
    echo "Compile sukses, menjalankan program..."
    java -cp build app.advsort.Main
else
    echo "Compile gagal!"
fi
