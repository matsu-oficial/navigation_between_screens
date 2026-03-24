# Checkpoint 1 - Navigation Screens App

Objetivo: Documentar e explicar implementacoes realizadas em relaçao aos parametros utilizados. 

#### Nome: Matheus Richard Hadermeck
#### Turma: 3SIR

## Implementacoes

### Tela de Perfil
Na PerfilScreen, declaramos as seguintes variaveis: 
nome (do tipo String) e idade (do tipo Int), que irao receber seus valores atraves do botao localizado na MenuScreen.

Apos receber esses valores, eles sao apresentados na tela atraves do $nome e $idade.

```
...
fun PerfilScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    nome: String,
    idade: Int
)
...
 Text(
            text = "PERFIL - $nome tem $idade anos",
            fontSize = 24.sp,
...
```

### Tela de Pedidos
Na PedidosScreen, declaramos a variavel cliente (do tipo String e opcional por conta da utilizacao do "?", podendo ser nula) e, 
logo apos receber o valor (tambem atraves da MenuScreen), ele e apresentado na tela atraves do $cliente.

```
...
fun PedidosScreen(modifier: Modifier = Modifier, navController: NavController, cliente: String?) {
    Box(
...
        Text(
            text = "PEDIDOS - $cliente",
            fontSize = 24.sp,
...
```

### Tela de Menu
Na MenuScreen, passamos os parametros presentes na PedidosScreen e na PerfilScreen sendo:

#### Parametros obrigatorios na PerfilScreen

```
...
            Button(
                onClick = { navController.navigate("perfil/Matsu/24") },
...
```

#### Parametros opcionais na PedidosScreen

```
...
            Button(
                onClick = { navController.navigate("pedidos?cliente=Matsu") },
...
```

A diferença presente na passagem desses parametros vem da forma como declaramos as variaveis na PerfilScreen e PedidosScree.

### MainActivity
Na Main, fizemos o import do navArgument e declaramos a rota e as variaveis que contem os valores para serem utilizados na tela, 
sendo notNull (!!) o nome e idade na tela de PerfilScreen e cliente opcional (sem !!) na PedidosScreen.

```
...
composable(
                            route = "perfil/{nome}/{idade}",
                            arguments = listOf(
                                navArgument("nome") { type = NavType.StringType },
                                navArgument("idade") { type = NavType.IntType }
                            )
                        ) {
                            val nome: String? = it.arguments?.getString("nome", "Usuário Genérico")
                            val idade: Int? = it.arguments?.getInt("idade", 0)
                            PerfilScreen(
                                modifier = Modifier.padding(innerPadding),
                                navController,
                                nome!!,
                                idade!!
                            )
                        }
                        composable(
                            route = "pedidos?cliente={cliente}",
                            arguments = listOf(navArgument("cliente") {
                                defaultValue = "Cliente Genérico"
                            })
                        ) {
                            PedidosScreen(
                                modifier = Modifier.padding(innerPadding),
                                navController,
                                it.arguments?.getString("cliente")
                            )
...
```

Nota: Valores default nao estao sendo puxados como deveriam na PerfilScreen.
