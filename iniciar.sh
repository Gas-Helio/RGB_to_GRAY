IP="127.0.0.1"
PORTA="12345"

while :
do

    echo "-----Configuração-----"
    echo "IP: $IP\nPORTA: $PORTA"
    echo "----------------------"

    echo "[1] Cliente\n[2] Servidor de aplicação\n[3] Servidor dos dados"
    echo "[4] Alterar IP\n[5] Alterar PORTA\n[0] Sair"
    read -p "> " op
    case $op in
        1)
            cd Cliente
            javac *.java
            java Tela $IP $PORTA
            rm *.class
            cd ..
        ;;
        2)
            cd ServidorAplicacao
            javac *.java -Xlint
            java Servidor $IP $PORTA
            rm *.class
            cd ..
        ;;
        3)
            #echo "Em construção"
            cd ServidorDados
            javac *.java
            java Servidor $IP $PORTA
            rm *.class
            cd ..
        ;;
        4)
            read -p "Nova IP: " IP
        ;;
        5)
            read -p "Nova Porta: " PORTA
        ;;
        0)
            echo "Saindo.."
            break
        ;;
        *)
            echo "Opção invalida"
        ;;
    esac
done