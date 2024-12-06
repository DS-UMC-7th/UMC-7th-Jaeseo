package umc.spring.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFood_category is a Querydsl query type for Food_category
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFood_category extends EntityPathBase<Food_category> {

    private static final long serialVersionUID = -812291304L;

    public static final QFood_category food_category = new QFood_category("food_category");

    public final umc.spring.study.domain.common.QBaseEntity _super = new umc.spring.study.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<umc.spring.study.domain.mapping.MemberPrefer, umc.spring.study.domain.mapping.QMemberPrefer> memberPreferList = this.<umc.spring.study.domain.mapping.MemberPrefer, umc.spring.study.domain.mapping.QMemberPrefer>createList("memberPreferList", umc.spring.study.domain.mapping.MemberPrefer.class, umc.spring.study.domain.mapping.QMemberPrefer.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QFood_category(String variable) {
        super(Food_category.class, forVariable(variable));
    }

    public QFood_category(Path<? extends Food_category> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFood_category(PathMetadata metadata) {
        super(Food_category.class, metadata);
    }

}

