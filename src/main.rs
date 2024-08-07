use actix_web::{post, App, HttpResponse, HttpServer};

#[post("/echo")]
async fn upload_file() -> HttpResponse {
    HttpResponse::Ok().body("Hello")
}

#[actix_web::main]
async fn main() -> std::io::Result<()> {
    HttpServer::new(|| { 
        App::new()
            .service(upload_file)
        })
        .bind(("127.0.0.1", 8080))?
        .run()
        .await
}
